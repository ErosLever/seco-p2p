package secop2p;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import secop2p.util.Serializer;

/**
 * @author eros
 *
 * Dummy class that represents an engine
 */
public class EngineInfo implements Serializable, RemoteEngine {

    private int id;
    private String name;
    private String host;
    private int port;

    public EngineInfo(int id, String name, String host, int port){
        this.id = id;
        this.name=name;
        this.host=host;
        this.port=port;
    }

    public EngineInfo(String name, String host, int port){
        this.name = name;
        this.host = host;
        this.port = port;
    }

    public EngineInfo(){
        //Nothing to check
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public String getHost(){
        return host;
    }

    public int getPort(){
        return port;
    }

    @Override
    public String toString(){
        return Serializer.toXML(this);
    }

    public InetSocketAddress getSocketAddress() {
        try {
            InetAddress ia = InetAddress.getByName(host);
            return new InetSocketAddress(ia, port);
        } catch (UnknownHostException ex) {
            Logger.getLogger(EngineInfo.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
