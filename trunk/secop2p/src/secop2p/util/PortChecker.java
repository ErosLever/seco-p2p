/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package secop2p.util;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.ServerSocketChannel;

/**
 *
 * @author eros
 */
final public class PortChecker {

    public static int START_PORT = 8000;

    public static synchronized ServerSocketChannel getBoundedServerSocketChannelOrNull(int num){
        ServerSocketChannel ssc = null;
        try {
            ssc = ServerSocketChannel.open();
            SocketAddress sa = new InetSocketAddress(Inet4Address.getLocalHost(),num);
            ssc.socket().bind(sa);
            return ssc;
        } catch (IOException e) {
            return null;
        }
    }
    
    public static synchronized ServerSocketChannel getBoundedServerSocketChannel(){
        return getBoundedServerSocketChannel(START_PORT);
    }

    public static synchronized ServerSocketChannel getBoundedServerSocketChannel(int startPort){
        ServerSocketChannel ssc;
        while( (ssc = getBoundedServerSocketChannelOrNull(startPort)) == null){
            startPort++;
        }
        return ssc;
    }

}