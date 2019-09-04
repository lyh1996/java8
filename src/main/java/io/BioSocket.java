package io;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-08-07 14:47
 * @since 1.7
 */
public class BioSocket {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(8888)){
            System.out.println("BIOServer has started listening on Port" + serverSocket.getLocalSocketAddress());
            while (true) {
                // 等待客户端的连接  会进行阻塞
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connection from " + clientSocket.getInetAddress());
                try(Scanner input = new Scanner(clientSocket.getInputStream())){
                    while (true) {
                        // 阻塞  等待客户端的连接
                        String request = input.nextLine();
                        if (Objects.equals("quit", request)) {
                            break;
                        }

                        // Thread 处理
                        System.out.println(String.format("From %s : %s",clientSocket.getRemoteSocketAddress(), request));
                        String response = "From BIOServer Hello "+request +".\n";
                        clientSocket.getOutputStream().write(response.getBytes());
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
