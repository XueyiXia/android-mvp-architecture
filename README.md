# android-mvp-architecture

Kotlin 版本的 MVP 开发框架，适用于中小型项目。

在过去的开发过程中，很多项目最初采用 MVC 或 MVP 架构，后期逐步演进到 MVVM。这个框架在 MVP 思路上做了一层基础封装，统一了 Presenter、Model、View 的职责，并提供了常用的 BaseActivity / BaseFragment / BasePresenter / BaseModel 等基类，减少重复代码，提高开发效率。

> 这个项目不是为了替代主流框架，而是为了在中小型项目中快速落地一套简洁、实用的 MVP 架构思路。

## 项目架构图

![image](https://user-images.githubusercontent.com/25949241/206661466-06902a35-bbe4-4869-976b-9f3a4eec024c.png)

## 设计思路

MVP 架构中，重点是将视图层、数据层和业务桥接层拆分开，降低耦合度。该框架的核心思想如下：

- View：负责界面展示和用户交互
- Presenter：负责连接 View 和 Model，处理业务逻辑
- Model：负责数据获取、数据处理和网络请求
- BaseActivity / BaseFragment：基础 UI 层，统一管理生命周期和通用行为

## 1. BasePresenter

`BasePresenter` 是 MVP 中最重要的桥接层之一，用于连接 View 和 Model，负责业务逻辑的分发和回调。

![image](https://user-images.githubusercontent.com/25949241/206661870-04152818-e7ba-48f5-b37d-b53d6515375d.png)

它的作用通常包括：

- 持有 View 引用
- 触发业务逻辑
- 接收 Model 返回的数据
- 将结果回调给 View

## 2. BaseModel

`BaseModel` 用于处理数据访问层逻辑，例如：

- 网络请求
- 数据本地缓存
- 数据检索
- 业务实体转换

它让网络请求和数据处理从 Activity / Fragment 中抽离，减少耦合，让业务逻辑更容易测试和维护。

![image](https://user-images.githubusercontent.com/25949241/206662878-1bd91984-a585-4c97-bc18-3c579a092a62.png)

## 3. BaseView

`BaseView` 是一个通用 UI 接口，通常用于约束 View 层必须提供的通用能力，例如：

- 显示加载中
- 隐藏加载中
- 显示错误信息
- 刷新界面

![image](https://user-images.githubusercontent.com/25949241/206663089-a7086e90-e80c-497a-a0a5-b260ebde8c5f.png)

## BaseActivity 和 BaseFragment

为了减少重复代码，框架额外抽象了 `BaseActivity` 和 `BaseFragment`。

它们的职责主要包括：

- 统一管理界面初始化
- 提供通用生命周期处理
- 统一封装 UI 刷新和错误提示
- 让子类只专注于具体业务逻辑

![image](https://user-images.githubusercontent.com/25949241/206663993-d22fdfbf-ea51-41d6-ba50-a187be145252.png)

## 在项目中使用

在实际业务中，通常需要：

- 继承 `BasePresenter`
- 继承 `BaseModel`
- 定义自己的业务 Presenter 和 Model
- 定义自己的 UI 回调接口

![image](https://user-images.githubusercontent.com/25949241/206664839-6daf953a-1271-4fc2-8812-a1a0e295e3cc.png)

具体使用请看 `HomeFragment` 等页面：

![image](https://user-images.githubusercontent.com/25949241/206665007-2d72ed35-e90a-48b6-9b73-e265311a3de5.png)

## 注意事项

因为创建 Presenter 的方式采用了抽象方法，所以在继承 `BaseActivity` 或 `BaseFragment` 时，需要实现 `createPresenter()`。

这样可以保证每个页面都有明确的 Presenter，并规范统一的调用方式。

![image](https://user-images.githubusercontent.com/25949241/206954359-0927a210-c977-43d7-b322-e358f3675c69.png)

使用方式基本相同，具体示例可参考 `SplashActivity`：

![image](https://user-images.githubusercontent.com/25949241/206954518-80e92fa5-404d-46a3-85bd-9a8f251d1508.png)

## 结构说明

项目结构大致如下：

```text
android-mvp-architecture/
├── app/
│   └── ...
├── framework_mvp/
│   └── ...
├── VersionPlugin/
│   └── ...
├── build.gradle
├── settings.gradle
├── gradlew
├── README.md
└── gradle.properties
```

其中：

- `app`：演示层/示例工程
- `framework_mvp`：MVP 基础框架模块
- `VersionPlugin`：统一版本管理

## How to use

在项目的 `build.gradle` 中添加依赖：

```gradle
dependencies {
    implementation 'com.github.XueyiXia:android-mvp-architecture:v1.0.1'
}
```

## 最终效果

![image](https://user-images.githubusercontent.com/25949241/206670090-997d05af-618c-4535-9760-1816e9e2efb5.png)

## 优势

- 适用于中小型项目
- 结构清晰，易上手
- 抽离通用 UI 和数据逻辑
- 减少重复代码
- 更容易维护和扩展

## 适用场景

- 中小型 Android 项目
- 业务逻辑较多但不复杂的项目
- 需要快速落地 MVP 架构的项目
- 需要统一 UI 基类、Presenter 基类和数据层封装的项目

## 结语

如果这个框架能帮助到你，欢迎在 GitHub 上点个 Star。

代码是最好的老师，欢迎下载 Demo 进行体验和二次开发。

Thanks you so much ... END
