# Gitub 명렁어 정리

## 환경 설정  
|명령어|설명|
|-|-|
|git config --global --list | 현재 설정정보 조회 --global 옵션은 전역설정에 대한 옵션 -> 현재 프로젝트에만 적용할 때는 영향 X|  
|git config --global --global user.name "유저이름" | 유저의 이름을 등록(필수) |
|git config --global --global user.name "이메일주소" | 이메일 주소를 등록(필수) |
|git config --global color.ui "auto" | 터미널에 표시되는 메세지에 색상을 표시 |


## 기본 명령어  
git --version //현재 git의 버전을 확인  
git init //현재 디렉토리에 git 저장소 생성  
git add 파일명 //스테이지에 올라가지 않은 파일을 업로드
git commit -m "보여줄 메시지" //스테이지에 올라간 파일을 커밋 -m은 메시지를 주는 옵션  
git status //커밋되지 않은 변경사항을 조회  
