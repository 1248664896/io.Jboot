/**
 * Copyright (c) 2016-2019, Michael Yang 杨福海 (fuhai999@gmail.com).
 * <p>
 * Licensed under the GNU Lesser General Public License (LGPL) ,Version 3.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.jboot.utils;

import java.util.concurrent.*;

/**
 * @author michael yang (fuhai999@gmail.com)
 * @Date: 2019/11/22
 */
public class NamedThreadPools {

    public static ExecutorService newFixedThreadPool(int nThreads, String name) {
        return newFixedThreadPool(nThreads, new NamedThreadFactory(name));
    }


    public static ExecutorService newFixedThreadPool(int nThreads, ThreadFactory threadFactory) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(),
                threadFactory);
    }


    public static ExecutorService newCachedThreadPool(String name) {
        return newCachedThreadPool(new NamedThreadFactory(name));
    }


    public static ExecutorService newCachedThreadPool(ThreadFactory threadFactory) {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(),
                threadFactory);
    }


    public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize, String name) {
        return newScheduledThreadPool(corePoolSize, new NamedThreadFactory(name));
    }


    public static ScheduledExecutorService newScheduledThreadPool(
            int corePoolSize, ThreadFactory threadFactory) {
        return new ScheduledThreadPoolExecutor(corePoolSize, threadFactory);
    }
}
