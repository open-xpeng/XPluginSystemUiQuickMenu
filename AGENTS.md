# Repository Guidelines（仓库贡献指南）

## 项目结构与模块组织
- 本仓库是 Android 多模块工程，核心模块在 `settings.gradle.kts` 中定义为 `:app` 和 `:stub-api`。
- `app/`：主插件模块（Xposed 入口与业务逻辑，主要为 Kotlin），源码在 `app/src/main/java`，资源在 `app/src/main/res`，资产在 `app/src/main/assets`。
- `stub-api/`：仅用于编译期的桩接口模块（Java），依赖 `stub-api/libs` 下的本地 jar。
- 版本与依赖统一维护在 `gradle/libs.versions.toml`。
- `app/build`、`stub-api/build`、根目录 `build` 均为产物目录，不应提交。

## 构建、测试与开发命令
- `.\gradlew.bat :app:assembleDebug`：构建调试 APK。
- `.\gradlew.bat :app:assembleRelease`：构建发布 APK（含混淆与资源收缩）。
- `.\gradlew.bat :stub-api:assembleDebug`：编译桩接口库。
- `.\gradlew.bat :app:lintDebug`：执行 Android Lint 静态检查。
- `.\gradlew.bat clean`：清理构建缓存与产物。

## 代码风格与命名规范
- 遵循 `.editorconfig`：UTF-8、CRLF、4 空格缩进、最大行长 512。
- `*.kt`/`*.kts` 文件要求以换行结束；保持 import 和格式由 IDE/Gradle Kotlin 风格自动整理。
- 包名全小写（如 `com.xiaopeng...`），类名 PascalCase，方法与变量 camelCase，常量 UPPER_SNAKE_CASE。
- Hook 相关逻辑优先拆分为小而清晰的类，避免在单文件堆叠过多反射/拦截代码。

## 测试指南
- 当前仓库未建立 `app/src/test` 与 `app/src/androidTest`，现阶段以“可编译 + 真机验证”为主。
- 提交前至少执行：`:app:assembleDebug` 与 `:app:lintDebug`。
- 新增测试时：
- 单元测试放 `app/src/test`，命名 `*Test`；
- 设备测试放 `app/src/androidTest`，命名 `*InstrumentedTest`。

## 提交与合并请求规范
- 建议采用 Conventional Commits，参考现有历史：`feat(quickmenu): ...`、`chore(build): ...`。
- 提交标题应包含模块或功能范围，描述“做了什么”而非“改了哪些文件”。
- PR 需包含：变更目的、影响模块、验证命令、关键日志；涉及 UI/交互请附截图或录屏。

## 安全与配置说明
- `app/build.gradle.kts` 中存在本地签名配置，仅供本地开发使用。
- 严禁提交真实生产密钥、真实密码或私有制品；敏感信息应通过本地文件或 CI 密钥管理注入。
