package com.Michalski.Minner.Mozdzierz.Ozga.Request;

import java.util.Optional;

public class RequestService {

    private final RequestRepository requestRepository = new RequestRepository();

    public void addRequest(Request request){
        requestRepository.save(request);
    }

    public void updateRequest(Request request){

        Optional<Request> byId = requestRepository.getById(request.getId());

        if(byId.isEmpty())
            return;

        Request requestUpdated = byId.get();

        requestUpdated.setStatus(request.getStatus());
        requestUpdated.setText(request.getText());
        requestUpdated.setAnswer(request.getAnswer());
        requestUpdated.setUser(request.getUser());

    }

    public Request getNextToView(){
        Optional<Request> request = requestRepository.getByPredictor(f -> f.getStatus() != Status.NIEROZPATRZONY).stream().findFirst();
        if(request.isEmpty())
            return null;

        Request requestGet = request.get();

        requestGet.setStatus(Status.ROZPATRYWANY);

        return requestGet;
    }

}
