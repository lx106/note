branch ��֧
Git �еķ�֧����ʵ�����Ͻ����Ǹ�ָ�� commit ����Ŀɱ�ָ��
HEAD ��������Ϊ��ǰ��֧�ı���
git checkout -b iss53 �൱��
git branch iss53
git checkout iss53
gitk �ɲ鿴��֧��

####################################################

���ǩ
git tag 
git tag -a tag1 -m "��һ����ǩ"
git tag -a tag0 818739fa23c4 -m 'mv file'  ����ʷ�ύ������ǩ
git push note tag0 �ύtag0  ����release�汾
git push origin --tags
�������ñ��� , 
$ git config --global alias.co checkout  ������
$ git config --global alias.br branch
$ git config --global alias.ci commit
$ git config --global alias.st status

git config --global alias.last "log --pretty=oneline"
gitk ����ͼ�ν���
$ git config --global alias.visual '!gitk'

#####################################################

git push [remote-name] [branch-name]
git remote rename origin og

git fetch [remote-name] ����ᵽԶ�ֿ̲�����ȡ�����㱾�زֿ��л�û�е�����

git checkout -- t.txt �����ռ������޸ĵ��ļ� ���˵��ϴ��ύ��״̬
git reset �������ݴ������ļ����˵������ռ�

git log --pretty=format:"%h - %an, %ar : %s" ��ʽ����ʷ�ύ��Ϣ
git log --graph

git log --pretty=oneline


git diff �鿴�ݴ����빤����������
git diff --cached 
git diff --staged �鿴�ݴ������ϴ��ύ�Ŀ��յ�����
git commit -a -m '�����ݴ沽���ύ'
git rm git.txt  -> commit -> push -> Ȼ���OK��
git rm --cached test.class ��ʾ�Ӹ����嵥��ɾ��,���ǵ�ǰĿ¼�»��Ǵ��ڣ��Ա��Ժ���.gitignore ���
git add *.java 
git add xxx.xxx
git mv test.txt t.txt �������ļ�
git log -p -2 �鿴��������ύ�Ĳ���
git log -p --word-diff

git config --list �鿴������Ϣ
git config user.email  �鿴�������� 
git config user.name
git help add �鿴add �����ĵ�

�ѱ�����Ŀ�ϴ���github 
1. ��github �ϴ���repository ���� note
2. ���裺 ����������note ���ļ��� �����ļ����� ����Ҽ� -> Git Bash Here
3. git init              # ��������repository
4. git add -A            # �ύ���ش���
5. git commit -m initial # ��һ��ֻ�Ǳ����ύ
6. git remote add origin https://github.com/lx106/note.git # ����Զ��repository
7. git push origin master # �ύ��Զ�ֿ̲�  
OK ��ɣ�
 

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
# Untracked files:  ��ʾ�������ļ�����û���κ�git����
#   add-me

git clone git@github.com:lx106/note.git ʹ��SSH Э��
git clone https://github.com/lx106/note.git note ʹ��httpsЭ��
git clone git://github.com/schacon/grit.git mygrit ʹ��git Э��

����Ŀ¼����������ļ� ֻ������״̬ �Ѹ���/ δ����
�Ѹ��� (δ����/ ���޸� /�����ݴ��� ) 
δ���� ��û���ϴθ���ʱ�Ŀ��գ�Ҳ���ڵ�ǰ���ݴ�����
ֻҪ�� ��Changes to be committed�� ��������ģ���˵�������ݴ�״̬