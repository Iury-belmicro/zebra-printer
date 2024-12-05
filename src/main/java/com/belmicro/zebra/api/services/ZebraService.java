package com.belmicro.zebra.api.services;

import org.springframework.stereotype.Service;

import com.belmicro.zebra.api.exception.NotFoundException;
import com.belmicro.zebra.api.model.ZplBelmicroObject;
import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.comm.TcpConnection;
import com.zebra.sdk.printer.ZebraPrinter;
import com.zebra.sdk.printer.ZebraPrinterFactory;
import com.zebra.sdk.printer.ZebraPrinterLanguageUnknownException;

@Service
public class ZebraService {
	
	public void sendZplOverTcp(ZplBelmicroObject obj) throws ConnectionException, NotFoundException{
		String zpl = obj.getZpl(); 
		final String ip = obj.getAddress(); 
        Connection thePrinterConn = new TcpConnection(ip, 6101);
        try {
            thePrinterConn.open();
            thePrinterConn.write(zpl.getBytes()); 
        } catch (ConnectionException e) {
            e.printStackTrace();
            thePrinterConn.close(); 
            throw e; 
        } finally {
            thePrinterConn.close();
        }
        return; 
    }
}
