## Buttom
[![](https://jitpack.io/v/karacce/Buttom.svg)](https://jitpack.io/#karacce/Buttom)

Buttom is a customizable button for Android written in kotlin.
## Installation
**1.** Add it in your root build.gradle file.
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
**2.** Add the dependency
```
dependencies {
	  implementation 'com.github.karacce:Buttom:v1.0'
}
```

## Usage
### Attributes
| XML Attribute | Description  |
| ------------- | ------------ |
| buttom_type   |Type of the button `flat` or `gradient` |
| gradient_type   |Type of the gradient `linear` or `radial` |
| gradient_orientation   |Orientation for *linear* gradient `top_bottom`, `right_left`, `bottom_top`, `left_right` |
| gradient_radius | Radius for *radial* gradient |
| background_color | Background color for `flat` button |
| gradient_start_color | Starting color for `gradient` button |
| gradient_end_color | Ending color for `gradient` button |
| stroke_size | Stroke size |
| stroke_color | Stroke color |
| corner_radius| Corner radius |


