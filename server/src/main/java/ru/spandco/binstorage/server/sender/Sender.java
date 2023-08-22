package ru.spandco.binstorage.server.sender;

import ru.spandco.binstorage.server.model.Request;

public interface Sender {
    public String SendRequestToSmev(Request req);

    public void SendRequestToSmev(String reqId);
}
