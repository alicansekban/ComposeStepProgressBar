<div align="start">
  <img src="images/Stepper.gif" width="300" height="500"/>
</div>
<br>

<h1 align="start">Compose-Stepper</h1>
<h3 align="start">
Step Indicator Library
A customizable step indicator library for Android, designed using Jetpack Compose, that visually represents multi-step progress with labels and checkmarks. This component can be easily integrated into any project to show progress across various steps in a user-friendly way.
</h3>

<h3 align="start">
Features
Customizable Colors: 
Define the colors for completed, current, and future steps.
Dynamic Labels: Display labels below each step to provide contextual information.
Progress Tracking: Visually show which steps are complete, in-progress, or pending.
Adaptive Layout: Adjusts automatically to fit the screen, avoiding overflow.
</h3>
<br>


## Getting Started


Add the following code to your project's _root_ `build.gradle` file:

```groovy
repositories {
    maven { url "https://jitpack.io" }
}
```

Next, add the dependency below to your _module_'s `build.gradle` file:

```gradle
dependencies {
 implementation 'com.github.alicansekban:ComposeStepProgressBar:1.0'
}
```

## Usage

### Basic

```kotlin

val stepList = arrayListOf(
            StepModel(
                title = "Step 1",
                isCompleted = true
            ),
            StepModel(
                title = "Step 2",
                isCompleted = true
            ),
            StepModel(
                title = "Step 3",
                isCompleted = true
            ),
            StepModel(
                title = "Step 4",
                isCompleted = false
            )
        )
       StepProgressBar(
            stepList = stepList,
            completedTextColor = Color.Red,
            completedBackgroundColor = Color.Red,
            completedDrawLineColor = Color.Red,
            modifier = Modifier.fillMaxWidth()
        )

```

![library step bar 1](https://github.com/user-attachments/assets/15131d01-c5a4-43c8-a081-cd6fe4656fa2)


### Customizations

```kotlin
StepProgressBar(
            stepList = stepList,
            completedTextColor = Color.Green,
            completedBackgroundColor = Color.Green,
            completedDrawLineColor = Color.Green,
            modifier = Modifier.fillMaxWidth()
        )
```

![library step bar 2](https://github.com/user-attachments/assets/e8c16cb2-857d-4bcd-9166-be27d27b98ac)


<h3 align="start">
Customization Options
Steps: Define the list of steps as StepModel for display.
Colors: Set custom colors for completed, and in-progress steps.
Icons: Use default icons (like checkmarks) or customize with your own icons.
</h3>

```kotlin
StepProgressBar(
            stepList = stepList,
            completedTextColor = Color.Green,
            completedBackgroundColor = Color.Green,
            completedDrawLineColor = Color.Green,
            uncompletedTextColor = Color.Red,
            uncompletedBackgroundColor = Color.Red,
            uncompletedDrawLineColor = Color.Red,
            modifier = Modifier.fillMaxWidth()
        )
```

License
This library is licensed under the MIT License. See the LICENSE file for more information.
  
