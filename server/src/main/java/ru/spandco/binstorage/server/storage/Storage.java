package ru.spandco.binstorage.server.storage;

import ru.spandco.binstorage.server.model.Request;

public interface Storage {
    public Request GetRequest(String id);

    public void SetRequestSmevId(String requestId, String smevId);
}
