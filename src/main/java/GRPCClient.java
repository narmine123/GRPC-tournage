import java.io.IOException;
import user.UserService;

import com.yrrhelp.grpc.User.APIResponse;
import com.yrrhelp.grpc.User.LoginRequest;
import com.yrrhelp.grpc.userGrpc;
import com.yrrhelp.grpc.userGrpc.userBlockingStub;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GRPCClient {
	


	public static void main(String[] args) {
		
		ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
		
		Channel channel = null;
		//stubs - generate from proto
		userBlockingStub userStub = userGrpc.newBlockingStub(channel);
		LoginRequest loginrequest = LoginRequest.newBuilder().setUsername("RAM").setPassword("RAM").build();
		APIResponse response = userStub.login(loginrequest);
		System.out.println(response.getResponsemessage());

	}
}
