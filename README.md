![PdfMaker Logo](https://github.com/mr-ravin/pdfmaker/blob/main/PdfMaker.png)
## PdfMaker

An opensource image to pdf maker android application. The produced pdfs contains pages of A4 size.

##### Application Developer: [Ravin Kumar](http://mr-ravin.github.io)


#### Instructions:
- Tap and hold over images when need to select multiple images.
- In case where only one image is needed to make a pdf, a short-touch on the screen will also work.

#### Download PDFMaker from Google PlayStore:
[<img src="https://play.google.com/intl/en_us/badges/images/generic/en_badge_web_generic.png" width="30%" height="30%" target="_blank">](https://play.google.com/store/apps/details?id=ravin.developer.pdfmaker)

#### Steps for using this app:

1. At start, this application will open the gallery.
2. Select and hold for pictures, in the sequence which you want them to be on the pdf.
3. Click on the SELECT button.
4. This app will then create an A4 size pdf with its detail shown in a notification.

#### Application View

![android application view 1](https://github.com/mr-ravin/pdfmaker/blob/main/screen1.jpg)

#### Install Dependency Library 

In the build.gradle file, add following lines:

```
dependencies {
    implementation 'com.tom_roush:pdfbox-android:1.8.10.0'
}
```

For more details, please do refer this [link](https://camposha.info/pdfbox-android/)

##### Note: In the source code, the code of RealPathUtil.java is taken from [link](https://gist.github.com/tatocaster/32aad15f6e0c50311626), which was made opensourced by [Merab Tato Kutalia](https://github.com/tatocaster). This file is used to retrieve file path from uri. 

```python
Copyright (c) 2021 Ravin Kumar
Website: https://mr-ravin.github.io

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation 
files (the “Software”), to deal in the Software without restriction, including without limitation the rights to use, copy, 
modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the 
Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the 
Software.

THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE 
WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR 
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
```
