# ECE4800J Proejct -  Rainbow (alpha ver.)

## Projct Introduction

&nbsp; &nbsp; This project mainly creates an Android application named **Rainbow** that can recognize colors from an image and label their names. Rainbow aims to help people with color vision deficiency to recognize colors at any time and anywhere quickly and conveniently.
 
&nbsp; &nbsp; In alpha version, Rainbow can recognize the color in an image in the place where the user touched, display its RGB value and the name of this color. Due to technical restriction, currently, user can't upload their own image for color recognition. This function will be added in subsequent releases. 

## Dependencies

&nbsp; &nbsp; This project is developed using Java in *Android Studio 2021.2.1.15*, and has dependency on *OpenCV 4.6.0*. To test the project, you need to first configure OpenCV library to Android Studio; For using the application, users don't need to download extra packages since OpenCV library is included in the *.apk* file.

## Directory Structure
├── README.md

├── AndroidManifest.xml 

│   └── res             

│   &nbsp;&nbsp;&nbsp;└── drawable &nbsp;&nbsp;&nbsp;&nbsp; <font color = grey>// image resource</font>

│   &nbsp;&nbsp;&nbsp;└── layout &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <font color = grey>// interface setting files</font>

│   &nbsp;&nbsp;&nbsp;└── values 

│   └── src/java/com/example/testproject  &nbsp;&nbsp;&nbsp;&nbsp; <font color = grey>// back-end source code</font>


## Instructions for use
&nbsp; &nbsp; If you only want to use this app and is uninterested in its code, you can download *Rainbow-alpha.apk* in the main directory and install it on your Android device. Both virtual device and physical device are available.

&nbsp; &nbsp; If you want to check the source code and run this application in test mode, you can create an empty project in Android Studio and paste the files into the corresponding *res* and *src* folders. Also, OpenCV library is needed for running. 

&nbsp; &nbsp; To use **Rainbow**, users can open the application and enter the main interface. In the interface, a sample image is shown on the top, with four rows of text representing "Color Name", "R", "G", "B" respectively. User can touch any place they want to examine on the image, and check the recognition result shown in the texts below. The result includes the RGB value of the point specified by the users, and the name of this color. 
