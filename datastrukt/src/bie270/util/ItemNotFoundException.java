package bie270.util;


public class ItemNotFoundException extends RuntimeException {
	
	public ItemNotFoundException()
    {
        super("ItemNotFound");
    }
    public ItemNotFoundException( String message )
    {
        super( message );
    }
	
}
