package defaultpackage;
import user.UserService;
import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GRPCServer {
	public static void main(String[] args)throws IOException ,InterruptedException{
		
		System.out.println("Starting GRPC Server" );

		Server server = ServerBuilder.forPort(9090).addService(new UserService()).build();
		
		server.start();
		System.out.println("Server started at" + server.getPort());
		server.awaitTermination();
	}
}