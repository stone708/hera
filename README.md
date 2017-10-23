# hera
hera is new project to automation
https://github.com/restsharp/RestSharp
https://github.com/JamesNK/Newtonsoft.Json
https://www.codeproject.com/Tips/79435/Deserialize-JSON-with-Csharp.aspx

AI Learning
http://blog.csdn.net/wemedia/details.html?id=43739


On Windows: 
    JAVA_OPTS = -Djavax.net.ssl.trustStore="%JAVA_HOME%\jre\lib\security\cacerts" -Djavax.net.ssl.trustStorePassword="changeit" 
    On Linux: 
    JAVA_OPTS = -Djavax.net.ssl.trustStore="$JAVA_HOME/jre/lib/security/cacerts" -Djavax.net.ssl.trustStorePassword="changeit" 
(info) On my local instance trustStore password is changeit so I belive, if you didn´t changed it, your is changeit as well. 

tomcat、junit运行时会从默认路径加载cacerts文件，如果main函数直接运行需要指定javax.net.ssl.trustStore文件路径，比如： 
java -Djavax.net.ssl.trustStore=$JAVA_HOME/jre/lib/security/cacerts -jar XXX.jar & 
