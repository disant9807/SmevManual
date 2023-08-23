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
    // Отправка запроса в СМЭВ
    public String SendRequest(String id) {
        // нужно ли подписать запрос ?
        Boolean isSignableRequest = requestSender.IsSignedRequest(id);
        // Если нужно, то подписываем
        if (isSignableRequest) {
            // Загружаем вложения запроса
            Object[] attachmentsToSign = requestSender.GetAttachmentsToSign(id);
            // вложение нет, то отправляем запрос на подпись
            if(attachmentsToSign.length == 0) {
                String result = requestSender.SendRequest(id, null);
                return result;
            } else {
                // если есть уже подписанные вложения у запроса, то возвращаем их
                return "Подписанные вложения";
            }
        } else {
            // если запрос уже подписан, то просто отправляем его
            Request req = storage.GetRequest(id);
            String smevId = sender.SendRequestToSmev(req);

            storage.SetRequestSmevId(id, smevId);
            return smevId;
        }
    }
}
