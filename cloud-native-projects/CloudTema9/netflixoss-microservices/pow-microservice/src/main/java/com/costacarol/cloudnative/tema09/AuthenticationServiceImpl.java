package com.costacarol.cloudnative.tema09;

import io.netty.buffer.ByteBuf;
import io.reactivex.netty.protocol.http.server.HttpServerRequest;
import rx.Observable;

public class AuthenticationServiceImpl implements AuthenticationService {
    @Override
    public Observable<Boolean> authenticate(HttpServerRequest<ByteBuf> request) {
        return Observable.just(Boolean.TRUE);
    }
}