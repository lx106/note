package com.example.controller;


import com.example.entity.User;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liuxun
 * @since 2018-04-04
 */
@Controller
@RestController
public class UserController {

    @Autowired
    private IUserService userService;
    @GetMapping("/user/{id}")
    public User get(@PathVariable int id){
        int count = userService.selectCount(null);
        System.out.println(count);
       return userService.getById(1);
    }

    /**
     * 不加事务
     * 前提条件 数据库中 2 不存在
     * @return 第一条插入成功，第二条因为主键冲突插入失败
     */
    @GetMapping("/unTransactional")
    public User unTransactional(){
        User user = new User();
        user.setId(2);
        user.setName("andy");
        userService.insert(user);
        userService.insert(user);
        return userService.getById(2);
    }

    /**
     * 默认事务传播行为 REQUIRED ,如果有事务，那么加入事务，没有的话新创建一个
     * 前提：2 不存在数据库
     * 结果： 创建事务，由于第二个插入语句失败，事务回滚，二个插入语句均失败。
     * @Transactional(propagation=Propagation.REQUIRED) ==  @Transactional
     */
    @GetMapping("/REQUIRED")
    @Transactional
    public User REQUIRED(){
        User user = new User();
        user.setId(2);
        user.setName("andy");
        userService.insert(user);
        userService.insert(user);
        return userService.getById(2);
    }

    /**
     * 事务传播行为 SUPPORTS 如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务的方式继续运行
     * 前提： id 为 2 存在, id 为 3 不存在 ，
     * 结果： 该controller 中的方法 SUPPORTS() 没有在其他事务方法中运行，所以会以非事物方法运行，所以3 插入成功，2 插入失败，
     * 如果 2 在 之前插入，那么 2,3 均失败，因为 2 已经存在直接报RuntimeException
     */
    @GetMapping("/SUPPORTS")
    @Transactional(propagation = Propagation.SUPPORTS)
    public User SUPPORTS(){
        User user = new User();
        user.setId(3);
        user.setName("andy");
        userService.insert(user);
        user.setId(2);
        userService.insert(user);
        return userService.getById(2);
    }

    /**
     * 事务传播行为 MANDATORY 必须在一个已有的事务中执行，否则抛出异常 (MANDATORY: 强制性的)
     * 前提：2 ，3 均不存在
     * 结果： 报错 IllegalTransactionStateException: No existing transaction found for transaction marked with propagation 'mandatory'
     * 该controller 中方法 MANDATORY() 没有在其他开启事务的方法中运行，所以报错。
     * 一般事务注解在service层上， 通常项目调用关系 浏览器请求url -> controller -> service -> dao
     *  而controller 是最外层的， 一般不会有其他controller调用 更不用说 service，dao 层
     *  涉及到数据库的 插入，更新，删除等操作，基本是要配置事务的，也就是强制使用事务，但是默认是REQUIRED而不是MANDATORY
     *  是因为它是不能创建事务的。
     */
    @GetMapping("/MANDATORY")
    @Transactional(propagation = Propagation.MANDATORY)
    public User MANDATORY(){
        User user = new User();
        user.setId(2);
        user.setName("andy");
        userService.insert(user);
        user.setId(3);
        userService.insert(user);
        return userService.getById(3);
    }

    /**
     * 事务传播行为 NEVER 不能在一个事务中执行，就是当前必须没有事务，否则抛出异常
     * 前提：2,3 不存在, userService.getById(3) 方法上加入了 @Transactional(propagation = Propagation.NEVER)
     * 结果：报错 IllegalTransactionStateException: Existing transaction found for transaction marked with propagation 'never'
     * 该controller中 NEVER()方法 以默认事务运行会创建事务, 而执行到userService.getById(3) 又不能以事务运行 ，2,3 插入失败
     * 如果删除 NEVER()上 @Transactional 注解，则 2,3 插入成功
     */
    @GetMapping("/NEVER")
    @Transactional
    public User NEVER(){
        User user = new User();
        user.setId(2);
        user.setName("andy");
        userService.insert(user);
        user.setId(3);
        userService.insert(user);
        return userService.getById(3);
    }

    /**
     * 一.事务传播行为 REQUIRES_NEW  不管是否存在事务，都创建一个新的事务，原来的挂起，新的执行完毕，继续执行以前的事务
     * 二.前提：2 不存在,  userService.insert2(user); 上添加 @Transactional(propagation = Propagation.REQUIRES_NEW)
     *                 userService.insert(user); 上无事务注解
     * 三.结果：REQUIRES_NEW() 方法开始，由于其上面的@Transactional注解，而当前又无事务， 所以就创建一个事务
     * 当执行到 userService.insert2(user); 其上面有 @Transactional(propagation = Propagation.REQUIRES_NEW)
     * 所以当前开启一个新的事务，并把 REQUIRES_NEW() 上的事务挂起，userService.insert2(user);执行完，这个新事务提交
     * 2 插入成功，再执行userService.insert(user); 主键冲突 当前REQUIRES_NEW()方法上的事务回滚，
     * 由于 userService.insert2(user); 与 REQUIRES_NEW() 是独立的事务所以 没有关系。并不会影响到userService.insert2(user);
     *
     */
    @GetMapping("/REQUIRES_NEW")
    @Transactional
    public User REQUIRES_NEW(){
        User user = new User();
        user.setId(2);
        user.setName("andy");
        userService.insert2(user);
        user.setId(2);
        userService.insert(user);
        return userService.getById(2);

        /*User user = new User();
        user.setId(2);
        user.setName("andy");
        userService.insert2(user);
        user.setId(3);
        userService.insert(user);
        return userService.getById(3);*/
    }

    /**
     * 以非事务方式执行操作，如果当前存在事务，就把当前事务挂起
     * 前提 2 不存在  ,userService.insert2(user); 上添加注解 @Transactional(propagation = Propagation.NOT_SUPPORTED)
     * 结果 第一条插入语句成功 第二条主键约束失败 ，数据库插入2,如果去掉上面的注解 我们知道 NOT_SUPPORTED() 方法因为加了 REQUIRED
     * 是一个原子操作 所以结果是什么都没插入。 NOT_SUPPORTED 把当前的事物挂起 (suspend 就是暂停，但是网上以及书籍都翻译为 挂起)
     * 我觉得这二个翻译在此处都不好，暂停： 给人感觉会停下来的意思  挂起： 到底是把谁挂起来啊？挂在哪个树上？
     */
    @GetMapping("/NOT_SUPPORTED")
    @Transactional(propagation = Propagation.REQUIRED)
    public User NOT_SUPPORTED(){
        User user = new User();
        user.setId(2);
        user.setName("andy");
        userService.insert2(user);
        user.setId(2);
        userService.insert2(user);
        return userService.getById(2);
    }

    /**
     * 一.事务传播行为 NESTED  PROPAGATION_NESTED使用具有可回滚到的多个保存点的单个物理事务。
     * 这种部分回滚允许内部事务作用域触发其作用域的回滚，尽管某些操作已被回滚，但外部事务能够继续物理事务。
     * 此设置通常映射到JDBC保存点，因此仅适用于JDBC资源事务。 请参阅Spring的DataSourceTransactionManager
     * 这个东西 我找了 spring reference  和 spring api 以及一些网上的资料都不知道这个是干嘛？
     * 最后搜了 stackoverflow 发现也有人同样找这个 注解的 Generic Example （通用案例），但是也没人贴出来
     * I have been having hard time, while getting through spring @Transactional(Propagation Nested)
       I have been searching all over internet and here, but unable to find any generic example of specific type regarding this..
       如果有人知道 可以留言
     */
    @GetMapping("/NESTED")
    @Transactional(propagation = Propagation.NESTED)
    public User NESTED(){
       return null;
    }


    private void test(){
        System.err.println();
        System.err.println();
        System.err.println();
        System.err.println();
        System.err.println();
        System.err.println();
        System.err.println();
        System.err.println();
    }
}

