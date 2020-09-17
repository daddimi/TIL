# Git

> Git은 분산현 버전 관리 시스템 (DVCS) 중 하나이다



## Git 사전 준비

> git을 사용하기 전에 commit을 남기는 사람에 대한 초기 정보 설정학

```bash
$ git config --global user.name 'daddimi'
$ git config --global user.email 'daddimi@gmail.com'
```

* 추후에 설정을 
* email 정보는 github에 등록된 email로 설정하는 것이 좋다
* 설정 내용을 확인하려면

```bash
$ git config --globla -l
```

> git bash 설치 링크



## 기초 흐름

0. 저장소 설정

```bash
$ git init
```

* git 저장소를 만들게 되면 해당 디렉토리에 .git/ 폴더가 생성
* git bash 에서는 (master) 로 현재 작업중인 브랜치가 표시됨



## 1. add

> commit을 위한 파일 목록 (staging area)

```bash
$ git add .
$ git add a.txt
$ git add md-images/ 
```

## 2. commit





## status 상태 확인

> git 에 대한 모든 정보는 status로 확인 할 수 있다. 









