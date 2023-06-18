# MZ2MO Server Code Convention

## Common Code Convention
### Purpose of Common Code Convention
적은 비용으로 프로덕트를 만들고 유지보수하기 위해, 코드의 가독성을 향상하기 위함입니다.

따라서 보다는 프로덕트의 유지보수 비용이 높은 우선순위를 가지게 되며, 
이를 위해 Common Code Convention을 어겨야할 경우가 생기면 이를 Breaking Conventions에 맞게 처리합니다.

### Conventions
#### Remarks
주석은 코드에서 표현이 불가능한 내용이 아닌, 코드에서 표현하면 안되는 내용을 표현하기위한 목적으로 사용합니다. (예를들어서 해당 코드의 고도화 가능성, 관련 문서 링크 등을 코드에 표현하는것은 지양되어야하므로, 주석에서 표현합니다.)

아래에서는 이를 위한 비관적 컨밴션(Negative Convention)들을 명시합니다.

**descriptive_remark_not_allowed** | 서술형 주석 사용 금지

로직의 작동방식, 역할 등을 서술할 목적으로 주석을 사용하지 않습니다.

작동방식/역할 등은 클래스/맴버/함수 등의 네이밍을 통해 명시합니다.

## Breaking Conventions
Breaking Conventions는 Common Code Convention을 준수하는것이 적합하지 않은 상황에서, 이에 대한 맥락을 코드레벨에서 관리하기위한 컨밴션입니다.

### Word Definition
- 해당 컨밴션이 적용된 (Common Code Convention을 준수하지 않는)코드를 Breaking Conventions Code라고 명명합니다.
- 만약 Breaking Conventions Code가 Common Code Convention을 모두 준수하게 될 경우, 또는 그 상황을 Breanking Conventions가 Solve 되었다고 명명합니다.
- 만약 Breaking Conventions Code가 Solve되진 않았으나, 다른 코드 또는 Common Code Convention 등의 변경으로 인해 맥락이 달라져 이에 맞게 수정되어야할 경우 또는 그 상황을 Breaking Conventions가 Update 되었다고 명명합니다.

### Conventions

- Common Code Convention을 위반해야할 경우, 멀티라인 주석(`/** **/`)으로 이에대한 맥락을 남깁니다.
- 주석의 첫번째 줄은 `/** BREAKING_CONVENTIONS **` 이어야합니다.
- 주석의 두번째 줄 이후에는 다음과 같은 내용이 기재되어있어야합니다.
  - 주석이 작성된 날짜와 어기게 되는 Common Code Convention의 고유명 
    
    `YYYY.MM.DD | <common_code_convention_name... -> join_comma>`
  - Common Code Convention을 어겨야하는 이유
  - Common Code Convention을 지키기 위해 추후 진행되어야할 작업
  - 기타 관련 맥락
- 주석의 마지막줄은 ` ** BREAKING_CONVENTIONS **` 이어야합니다.
- 만약 Breaking Conventions 중, Common Code Convention을 지킬 수 있는 상황이 생길 경우, 현재 진행중인 스프린트의 중간 수준의 우선순위로서 Breaking Conventions를 Solve합니다.
- 리팩토링 작업범위 내에 Breaking Conventions Code가 존재할 경우, 이를 Solve/Update 합니다.

다음은 Breaking Conventions에 대한 주석 예시입니다.
```kotlin
/** BREAKING_CONVENTIONS **
 * 2023.06.18 | descriptive_remark_not_allowed, other_conver
 * 이모지 투표 기반 노래 감정분석 로직은 비선언형 SDK(dlova)에 의존적으로 로직이 작성됩니다.
 * 따라서 주석을 통한 서술 없이 로직을 가독성을 다른 코드수준으로 유지하기 위해서는 
 * dlova sdk에 대한 추상화 계층의 개발이 필수불가결합니다.
 * 현재 해당 작업이 하나의 스프린트 내에서 마무리되어야하므로, 추상화 계층을 개발할 시간적 여유가 없기 때문에, 
 * 따라서 주석을 통해 해당 로직에 대한 가독성을 향상시킵니다.
 * 추후 dlova sdk에 대한 추상화 계층 개발 후 해당 주석들을 제거해야합니다.
 ** BREAKING_CONVENTIONS **/
```