# Push Architecture in CLI

Implementation of the Client-Server Architecture : Push, using Remote Method Invocation.

## How to run ?

1. Execute <code>Server.java</code>

2. When "Server's ready", execute <code>Client.java</code>, and enter a username.

3. Then, execute <code>Client2.java</code>, and enter a username for the second Client.

4. Next, in the <b>command line terminal</b> of <b>Client</b> or <b>Client2</b>, inform the receiver <b><u>receiver</u></b> and your <b><u>message</u></b>.

5. Finally, the <b><u>receiver</u></b> receives the message from the <b><u>emitter</u></b> in its <b>command line terminal</b>.

## Model Description (Subject)

> <code>Client</code> apps own a reception component : <code>ReceiverImpl</code>, that enable <code>Server</code> app to send them immediately received messages (instant messaging).
> 
> Reception components also provide functions that enable <code>Server</code> app to push to clients the list of connected clients (<code>initClients</code> function) then to update this list (<code>addClient</code> and <code>remClient</code> functions).
> 
> Reception component <code>ReceiverImpl</code> references are provided to <code>Server</code> app thanks to an input parameter (<code>Receiver</code>) of the connect function of the server’s <code>Connection</code> component. 
> This function returns a reference of the <code>Emitter</code> component that is instantiated to be used by the client to send messages to the <code>Server</code> (and that incidentally represents the client app on the server).
> 
> <b>Sylvain VAUTTIER</b>, IMT Mines Alès.

## Looking ahead

- Creating a User Interface