# Interview Preparation App
It is an application which has Questions and Answers about Android which are usually asked in job interviews. It helps you in preparing and prepping your skills. <br>

## Features:
1. It has its *own logo*: You can customize the logo in your application, and now it will not be the default android icon. <br>
2. It has *two different levels* of difficulty: <br>
    a. Simple Questions <br>
    b. Tough Questions <br>
   You can add your own levels, like, Intermediate or Expert level questions. <br>
3. There is an option **See Our Other Apps** where you can check out some other apps of the same genre. <br>
4. There is an option **Rate Our App** which redirects you to the Google App Store, where you can rate the app. <br>
*Note: This will work only if your application is already deployed on App Store.* <br>
5. There's a *Mute* and a *Speak* option. <br>
    a. Speak: The application would read out the answer to you. <br>
    b. Mute: You can make the voice stop at any second.

# How do you use this repository?
You can fork the repository, then download the folder to your system.
After that you can simply take the files and paste it in the required folders. Et Voila !


# Install Pre-requisites

1. Download the Android IDE: Android Studio (you may need to install java by following the prompts)
  a. Optional: Install the Android SDK: ``` brew install android-sdk ``` , Select the SDK that ```brew``` logged out back in the previous command
2. Open this project with in Android Studio IDE
3. The IDE will complain about *"Gradle sync failed".* Just follow what it says.
4. Once the IDE stops giving suggestions go to **Tools -> Android -> SDK Manager** and do what the SDK Manager says.
5. Once the SDK Manager stops giving suggestions, use it to install the Google Repository and the Android Support Repository.

# How do you use this repository?
Clone or download this repo<br>
```
https://github.com/anjalisi/InterviewAppPrep
```
After that you can simply take the files and paste it in the required folders. Et Voila !

# Setup Virtual Device
## Running on a virtual device
1. Open the AVD Manager (***Tools -> Android -> AVD Manager***).
2. Create a new Virtual Device. The size/model doesn't matter that much
3. Select a system image that has both a _x86_64 ABI and Google Play Services_.
4. Finish and Click Play!
