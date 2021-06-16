    <appender name="STASH" class="net.logstash.logback.appender.LogstashTcpSocketAppender">
        <destination>localhost:5044</destination>
        <includeCallerData>true</includeCallerData>
        <encoder class="net.logstash.logback.encoder.LogstashEncoder">
            <includeCallerData>true</includeCallerData>
            <providers>
                <timestamp>
                    <timeZone>UTC</timeZone>
                </timestamp>
                <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{80}.%M.%L - %msg %n</pattern>
            </providers>
        </encoder>
    </appender>
    
        <root level="INFO">
        <!--本地开发调试将控制台输出打开，同时将日志文件输出关闭，提高日志性能；线上部署请务必将控制台输出关闭-->
        <appender-ref ref="STDOUT"/>
        <appender-ref ref="STASH"/>
    </root>
    
    		<dependency>
			<groupId>net.logstash.logback</groupId>
			<artifactId>logstash-logback-encoder</artifactId>
			<version>6.3</version>
		</dependency>
South China University of Technology
Bachelor|Information management and information systems
