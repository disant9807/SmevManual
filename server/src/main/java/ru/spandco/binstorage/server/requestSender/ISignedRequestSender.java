package ru.spandco.binstorage.server.requestSender;

public interface ISignedRequestSender {
    public Boolean IsSignedRequest(String requestId);

    public Object[] GetAttachmentsToSign(String reqeustId);

    public String SendRequest(String requestId, Object[] AttSignature);
}
