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