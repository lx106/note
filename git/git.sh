branch 分支
Git 中的分支，其实本质上仅仅是个指向 commit 对象的可变指针
HEAD 可以想象为当前分支的别名
git checkout -b iss53 相当于
git branch iss53
git checkout iss53
gitk 可查看分支树

####################################################

打标签
git tag 
git tag -a tag1 -m "第一个标签"
git tag -a tag0 818739fa23c4 -m 'mv file'  给历史提交创建标签
git push note tag0 提交tag0  发布release版本
git push origin --tags
可以设置别名 , 
$ git config --global alias.co checkout  命别名
$ git config --global alias.br branch
$ git config --global alias.ci commit
$ git config --global alias.st status

git config --global alias.last "log --pretty=oneline"
gitk 弹出图形界面
$ git config --global alias.visual '!gitk'

#####################################################

git push [remote-name] [branch-name]
git remote rename origin og

git fetch [remote-name] 命令会到远程仓库中拉取所有你本地仓库中还没有的数据

git checkout -- t.txt 工作空间中已修改的文件 回退到上次提交的状态
git reset 将存入暂存区的文件回退到工作空间

git log --pretty=format:"%h - %an, %ar : %s" 格式化历史提交信息
git log --graph

git log --pretty=oneline


git diff 查看暂存区与工作区的区别。
git diff --cached 
git diff --staged 查看暂存区与上次提交的快照的区别
git commit -a -m '跳过暂存步骤提交'
git rm git.txt  -> commit -> push -> 然后就OK了
git rm --cached test.class 表示从跟踪清单中删除,但是当前目录下还是存在，以便以后在.gitignore 添加
git add *.java 
git add xxx.xxx
git mv test.txt t.txt 重命名文件
git log -p -2 查看最近二次提交的差异
git log -p --word-diff

git config --list 查看配置信息
git config user.email  查看具体配置 
git config user.name
git help add 查看add 命令文档

把本地项目上传到github 
1. 在github 上创建repository 起名 note
2. 假设： 本地有名了note 的文件夹 进入文件夹中 鼠标右键 -> Git Bash Here
3. git init              # 创建本地repository
4. git add -A            # 提交本地代码
5. git commit -m initial # 这一步只是本地提交
6. git remote add origin https://github.com/lx106/note.git # 关联远程repository
7. git push origin master # 提交到远程仓库  
OK 完成！
 

git init
echo Change me > change-me
echo Delete me > delete-me
git add change-me delete-me
git commit -m initial

echo OK >> change-me
rm delete-me
echo Add me > add-me

git status
# Changed but not updated:
#   modified:   change-me
#   deleted:    delete-me
# Untracked files:  表示新增的文件，还没有任何git操作
#   add-me

git clone git@github.com:lx106/note.git 使用SSH 协议
git clone https://github.com/lx106/note.git note 使用https协议
git clone git://github.com/schacon/grit.git mygrit 使用git 协议

工作目录下面的所有文件 只有两种状态 已跟踪/ 未跟踪
已跟踪 (未更新/ 已修改 /放入暂存区 ) 
未跟踪 既没有上次更新时的快照，也不在当前的暂存区域
只要在 “Changes to be committed” 这行下面的，就说明是已暂存状态