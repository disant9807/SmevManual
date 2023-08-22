package ru.spandco.binstorage.server.messageProcessor;

// Обработать входящий запрос СМЭВ
public interface IIncomingRequestMsgProc {
    public boolean ProcessRequest(IncomingSmevRequest smevRequest);
}
