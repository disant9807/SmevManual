package ru.spandco.binstorage.server.controllers;

import ru.spandco.binstorage.server.model.Request;
import ru.spandco.binstorage.server.requestSender.ISignedRequestSender;
import ru.spandco.binstorage.server.sender.Sender;
import ru.spandco.binstorage.server.storage.Storage;

public class ManualController {

    private ISignedRequestSender requestSender;

    private Storage storage;

    private Sender sender;

    public String CreateRequest(
            String Type,
            String UserId,
            String JsonBody
    ) {
        throw new RuntimeException();
    }

    public String SendRequest(String id) {
        Boolean isSignableRequest = requestSender.IsSignedRequest(id);

        if (isSignableRequest) {
            Object[] attachmentsToSign = requestSender.GetAttachmentsToSign(id);

            if(attachmentsToSign.length == 0) {
                String result = requestSender.SendRequest(id, null);
                return result;
            } else {
                return "Подписанные вложения";
            }
        } else {
            Request req = storage.GetRequest(id);
            String smevId = sender.SendRequestToSmev(req);

            storage.SetRequestSmevId(id, smevId);
            return smevId;
        }
    }
}
