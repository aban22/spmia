package com.thoughtmechanix.spmiaorganizationservice.hystrix;

import java.util.concurrent.Callable;

import com.thoughtmechanix.spmiaorganizationservice.utils.UserContext;
import com.thoughtmechanix.spmiaorganizationservice.utils.UserContextHolder;

public final class DelegatingUserContextCallable<V> implements Callable<V> {
    
	private final Callable<V> delegate;
    private UserContext originalUserContext;

    public DelegatingUserContextCallable(Callable<V> delegate,
                                             UserContext userContext) {
        this.delegate = delegate;
        this.originalUserContext = userContext;
    }

    public V call() throws Exception {
        UserContextHolder.setContext( originalUserContext );

        try {
            return delegate.call();
        }
        finally {
            this.originalUserContext = null;
        }
    }

    public static <V> Callable<V> create(Callable<V> delegate,
                                         UserContext userContext) {
        return new DelegatingUserContextCallable<V>(delegate, userContext);
    }
}