package com.weibo.concurrent;

import org.junit.extensions.cpsuite.ClasspathSuite.ClassnameFilters;
import org.junit.runner.RunWith;

@RunWith(ConcurrentSuite.class)
@ClassnameFilters({"com.weibo.cases.xuelian.*Test", "!.*RemindTest","com.weibo.cases.maincase.*Xuelian"})

public interface IntegrationBeijingOneTests {

}