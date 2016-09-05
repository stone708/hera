package com.weibo.concurrent;

import org.junit.experimental.categories.Categories;
import org.junit.extensions.cpsuite.ClasspathSuite;
import org.junit.internal.builders.AllDefaultPossibilitiesBuilder;
import org.junit.runner.Runner;
import org.junit.runners.ParentRunner;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;
import org.junit.runners.model.RunnerScheduler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hugang
 *
 **/
public final class ConcurrentSuite extends ClasspathSuite {

	public static Runner MulThread(Runner runner) {
		if (runner instanceof ParentRunner) {
			// setScheduler(RunnerScheduler scheduler):Sets a scheduler that
			// determines the order and parallelization of children
			// RunnerScheduler:Represents a strategy for scheduling when
			// individual test methods should be run (in serial or parallel)
			((ParentRunner) runner).setScheduler(new RunnerScheduler() {
				private final ExecutorService fService = Executors.newCachedThreadPool();

				// private final ExecutorService fService =
				// Executors.newFixedThreadPool(10);

				// Schedule a child statement to run
				public void schedule(Runnable childStatement) {
					this.fService.submit(childStatement);
				}

				// Override to implement any behavior that must occur after all
				// children have been scheduled
				public void finished() {
					try {
						this.fService.shutdown();
						this.fService.awaitTermination(9223372036854775807L, TimeUnit.NANOSECONDS);
					} catch (InterruptedException e) {
						e.printStackTrace(System.err);
					}
				}
			});
		}
		return runner;
	}

	public ConcurrentSuite(final Class<?> klass) throws InitializationError {
		// 调用父类ClasspathSuite构造函数
		// AllDefaultPossibilitiesBuilder根据不同的测试类定义（@RunWith的信息）返回Runner,使用职责链模式
		super(klass, new AllDefaultPossibilitiesBuilder(true) {
			@Override
			public Runner runnerForClass(Class<?> testClass) throws Throwable {
				List<RunnerBuilder> builders = Arrays.asList(new RunnerBuilder[] { ignoredBuilder(), annotatedBuilder(),
						suiteMethodBuilder(), junit3Builder(), junit4Builder() });
				for (RunnerBuilder each : builders) {
					// 根据不同的测试类定义（@RunWith的信息）返回Runner
					Runner runner = each.safeRunnerForClass(testClass);
					if (runner != null)
						// 方法级别，多线程执行
						return MulThread(runner);
				}
				return null;
			}
		});

		// 类级别，多线程执行
		setScheduler(new RunnerScheduler() {
			private final ExecutorService fService = Executors.newCachedThreadPool();

			public void schedule(Runnable paramRunnable) {
				// TODO Auto-generated method stub
				fService.submit(paramRunnable);
			}

			public void finished() {
				// TODO Auto-generated method stub
				try {
					fService.shutdown();
					fService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
				} catch (InterruptedException e) {
					e.printStackTrace(System.err);
				}
			}

		});
	}

}