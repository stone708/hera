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

Contributed software engineering expertise in the development of products through the software lifecycle, from requirment definition through successul deployment.
Excelled at rapid application development and management of technological issues for assigned projects, earning the highest customer satisfaction rating for all software soluctions delivered.
Lead the architecture and development in one new web application (MVC, Entity Framework, repository pattern)
Worked on multiply legcy systems adding value according to the requirments (C$, WCF, VB)

Played a key role in developing 
