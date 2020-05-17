# Commit 메세지에 자동으로 issue number 추가하기
* 출처: [블로그](https://myeongjae.kim/blog/2019/02/02/prepare-commit-msg-hook-issue-number/)

* 스크립트 작성
```shell
#!/bin/sh
# .git/hooks/prepare-commit-msg
#
# Automatically add branch name and branch description to every commit message except merge commit.
# https://stackoverflow.com/a/18739064
#

COMMIT_EDITMSG=$1

addBranchNumber() {
  NAME=$(git branch | grep '*' | sed 's/* //') 
ISSUE_NUMBER=`echo $NAME | cut -d '-' -f1`
  DESCRIPTION=$(git config branch."$NAME".description)
  echo "[#$ISSUE_NUMBER] $(cat $COMMIT_EDITMSG)" > $COMMIT_EDITMSG
  if [ -n "$DESCRIPTION" ] 
  then
     echo "" >> $COMMIT_EDITMSG
     echo $DESCRIPTION >> $COMMIT_EDITMSG
  fi 
}

MERGE=$(cat $COMMIT_EDITMSG|grep -i 'merge'|wc -l)

if [ $MERGE -eq 0 ] ; then
  addBranchNumber
fi
```
* 작성 위치: `.git/hooks/prepare-commit-msg`
* 브랜치 생성 형식: `숫자-브랜치이름`
    * ex) `7-spring_rest_docs`
* 커밋 메세지에 자동으로 [#숫자]를 추가
* 예시
![Screenshot from 2020-05-18 00-33-37](https://user-images.githubusercontent.com/58318786/82152971-b14c2180-989f-11ea-97a0-55e88092190c.png)
