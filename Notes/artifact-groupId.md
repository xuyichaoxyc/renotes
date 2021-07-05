直接使用Spring Initializr创建项目，需要填入group与artifact。这两个起名是随便起的吗？有啥名堂？下面讲讲~

【含义】

groupId和artifactId是maven管理项目包时用作区分的字段，就像是地图上的坐标。

groupId：groupId分为几个字段，例如com.piggy，前面的com叫【域】，后面的是你自己起的域名。

artifactId：artifactId一般是项目名或者模块名。

【作用】

一般来说，包名根目录=groupId+artifactId。这个是不允许和别人重复的，尤其是需要上线的项目。一般公司为了不重复都会注册一个域名（URL用的那种），这样就肯定不会重复了。