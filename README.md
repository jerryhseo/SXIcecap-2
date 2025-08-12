## 개발자 노트

### 1. Tables
- 테이블은 자산 테이블과 비자산 테이블로 구분
모든 자산 테이블은 다음의 공통 컬럼을 가진다.

|필드|타입|설명|
|------|------|------|
|componyId|long|포털 아이디. Liferay는 한 개 이상의 포털을 수용|
|groupId|long|사이트, 조직, 사용자 그룹 아이디|
|userId|long|사용자 아이디|
|userName|String|사용자 명|
|createDate|Date|생성일|
|modifiedDate|Date|최종수정일|
|status|int|워크플로우 상에서의 데이터 상태|
|statusByUserId|long|데이터 상태 최종 변경 사용자 아이디|
|statusByUserName|String|데이터 상태 최종 변경 사용자 명|
|statusDate|Date|데이터 상태 최종 변경일|
|lastPublishDate|Date|최종 공개일|

#### 1) Parameter Table
- 자산 등록 테이블

|필드|타입|설명|
|------|------|------|
|paramName|String|파라메터 코드 명. 향후 데이터를 이용한 프로그램의 변수로 사용|
|paramVersion|String|파라메터 버전|
|paramType|String|파라메터 타입|
|displayName|String|[다국어] UI 상에 표시되는 파라메터 표시명|
|definition|String|[다국어] 파라메터 정의|
|tooltip|String|[다국어] 짧은 도움말|
|synonyms|String|유사 및 동의 파라케터|
|typeProperties|String|파라메터 타입에 따라서 정의될 수 있는 추가 속성들. JSON 문자열|
|standard|boolean|표준화 여부|




