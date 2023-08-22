package ru.spandco.binstorage.server.messageProcessor;

//Обработчик сообщений из входящих очередей СМЭВ
public interface IIncomingMsgProc {
    public boolean ProcessRequest(IncomingSmevRequest smevRequest);

    public boolean ProcessResponse (IncomingSmevResponse smevMessage);
}
