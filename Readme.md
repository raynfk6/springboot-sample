# 主題面板

## Spring Security

- 進行 formLogin，再加 JWT 須測試

## Layers

- Domain Layer: domain(業務核心)
    - 業務核心物件、規則
    - 包含 Entity、ValueObject、Repository Interface
- Use Case Layer: application(應用邏輯)
    - 處理業務流程、協調 domain 模型、呼叫 repository 等，不依賴外部框架。
    - 實現具體操作流程，它負責實現「使用者想完成什麼動作」，例如「註冊帳號」、「建立專案」、「查詢使用者資訊」等。
    - Service 命名建議：如果你的 AccountService 是實作具體的業務流程（而非「共用邏輯」），建議名稱可改成 AccountUseCase 或 RegisterAccountUseCaseImpl，讓角色更明確。
- Interface Adapters Layer: controller(Web 入口)
    - 將外部輸入轉成 application 用的資料格式，處理 HTTP 請求，解析參數，調用 Use Case
    - 有些人（包含我剛剛）會把最外層統稱為 Framework & Interface Layer，而你具體說的 Interface / Adapter Layer 是 Clean Architecture 的正式名稱
- Frameworks & Drivers Layer: infrastructure
    - 資料庫、Spring Security、Spring、DB、Web 框架的設定

## A couple of things to be clear
- "Access / Call" is different to "Depend / Import". Domain services and entities "access / call" repository instances to find the aggregates, doesn't mean they "depend on / import" repository implementation.
- Domain services and entities sometimes DO NEED to query data to complete their operations.
- [reference](https://stackoverflow.com/questions/72230883/ddd-repository-interfaces-in-domain-or-application-layer)