package com.Michalski.Minner.Mozdzierz.Ozga.Request;

import com.Michalski.Minner.Mozdzierz.Ozga.User.User;

import java.util.Objects;
import java.util.Optional;

public class RequestService {

    private final RequestRepository requestRepository = new RequestRepository();

    public void addRequest(Request request){
        requestRepository.save(request);
    }

    public void updateRequest(Request request, User bokUser){

        if(!bokUser.isBokManager())
            throw new IllegalStateException("User is not bok!");

        if(request.getBokUser() == null || !Objects.equals(request.getBokUser().getId(), bokUser.getId()))
            throw new IllegalStateException("Current request is being operate by other BokUser");

        Optional<Request> byId = requestRepository.getById(request.getId());

        if(byId.isEmpty())
            return;

        Request requestUpdated = byId.get();

        requestUpdated.setStatus(request.getStatus());
        requestUpdated.setText(request.getText());
        requestUpdated.setAnswer(request.getAnswer());
        requestUpdated.setUser(request.getUser());

    }

    public Request getNextToView(User bokUser){

        if(!bokUser.isBokManager())
            throw new IllegalStateException("User is not bok!");

        Optional<Request> request = requestRepository.getByPredictor(f -> f.getStatus() != Status.NIEROZPATRZONY).stream().findFirst();
        if(request.isEmpty())
            return null;

        Request requestGet = request.get();

        requestGet.setStatus(Status.ROZPATRYWANY);

        return requestGet;
    }

}
