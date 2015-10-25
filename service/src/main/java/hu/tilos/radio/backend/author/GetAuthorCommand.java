package hu.tilos.radio.backend.author;

import hu.tilos.radio.backend.bus.Command;

public class GetAuthorCommand extends Command{

    private String idOrAlias;

    public GetAuthorCommand(String idOrAlias) {
        this.idOrAlias = idOrAlias;
    }

    public String getIdOrAlias() {
        return idOrAlias;
    }

    public void setIdOrAlias(String idOrAlias) {
        this.idOrAlias = idOrAlias;
    }
}
