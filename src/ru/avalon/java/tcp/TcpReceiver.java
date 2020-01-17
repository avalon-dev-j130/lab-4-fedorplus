package ru.avalon.java.tcp;

import java.io.*;
import java.net.*;

/**
 * Упражнение на выаботку умений связанных с получением сообщений,
 * отправленных с использованием протокола TCP.
 *
 * @author Daniel Alpatov
 */
public final class TcpReceiver {

    public static void main(String[] args) throws IOException {
        // 1. Определяем порт, на котором ожидается соединение.
        final int port = 1234;
        // 2. Подготавливаем серверный сокет.
        final ServerSocket listener = prepareServerSocket(port);
        // 3. Принимаем соединение.
        Socket socket = listener.accept();
        // 4. Полоучаем сообщение.
        final String message = receive(socket);
        // отправляем ответ           
          
       String response = new StringBuffer(message).reverse().toString();
        send(socket, response);
        
        // 5. Закрываем соединение.
        socket.close();
        // 6. Закрываем серверный сокет.
        listener.close();
    }

    /**
     * Возвращает серверный сокет, связанный с портом, описанным
     * параметром {@code port}.
     *
     * @param port порт, на котором предполагается получать входящие
     *             соединения.
     *
     * @return серверный сокет, связанный с портом {@code port}.
     */
    private static ServerSocket prepareServerSocket(int port) throws IOException{
        /*
         * TODO Реализовать метод prepareServerSocket класса TcpReceiver
         */
        return new ServerSocket(port);
    }

    /**
     * Возвращает сообщение, прочитанное из входящего потока,
     * указанного сокета.
     *
     * @param socket сокет, описывающий сетевое соединение.
     *
     * @return строковое сообщение.
     */
    private static String receive(Socket socket) throws IOException{
        /*
         * TODO Реализовать метод receive класса TcpReceiver
         */
        InputStream stream = socket.getInputStream();
        Reader reader = new InputStreamReader(stream);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();   
        System.out.println(line);
        return line;
    }
    
     private static void send(Socket socket, String message) throws IOException {
        /*
         * TODO Реализовать метод send класса TcpSender
         */;
        OutputStream stream = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(stream);
        writer.write(message);
        writer.flush();
        System.out.println(message);
    }

}
