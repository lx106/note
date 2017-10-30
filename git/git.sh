git diff 查看暂存区与工作区的区别
git diff --cached 
git diff --staged 查看暂存区与上次提交的快照的区别
git commit -a -m '跳过暂存步骤提交'
git rm git.txt  -> commit -> push -> 然后就OK了
git rm --cached test.class 表示从跟踪清单中删除,但是当前目录下还是存在，以便以后在.gitignore 添加
git add *.java 
git add xxx.xxx
git mv test.txt t.txt 重命名文件
git log -p -2 查看最近二次提交的差异


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