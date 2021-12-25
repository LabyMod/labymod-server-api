# LabyMod Server API
[![Scrutinizer Code Quality](https://scrutinizer-ci.com/g/LabyMod/labymod-server-api/badges/quality-score.png?b=master)](https://scrutinizer-ci.com/g/LabyMod/labymod-server-api/?branch=master)
[![Discord](https://img.shields.io/discord/412724944112320513.svg)](https://labymod.net/dc/dev)
[![CLA assistant](https://cla-assistant.io/readme/badge/LabyMod/labymod-server-api)](https://cla-assistant.io/LabyMod/labymod-server-api)

Our new Server API allows you to communicate between the LabyMod client and the server by using simple JSON messages. It also allows you to enable or disable LabyMod features. 
If you want to find out how our API works, visit https://docs.labymod.net/pages/server/introduction/

Creating Plugin with LabyMod API
----------------

```groovy
repositories {
	maven { url 'https://jitpack.io' }
}

dependencies {
	implementation 'com.github.LabyMod:labymod-server-api:Tag'
}
```

```xml
<repositories>
	<repository>
		   <id>jitpack.io</id>
		   <url>https://jitpack.io</url>
	</repository>
</repositories>

<dependencies>
	<dependency>
	    <groupId>com.github.LabyMod</groupId>
	    <artifactId>labymod-server-api</artifactId>
	    <version>Tag</version>
	</dependency>
</dependencies>
```

