# spring事务



## 1.事务的介绍

​	事务是一系列的动作，它们综合在一起才是一个完整的工作单元。也就是一个事务的这些动作必须全部完成，如果有一个失败的话，那么事务就会回滚到最开始的状态，仿佛什么都没发生过一样。 通常都说事务有四个特性，一般来说最完美的事务是都有ACID这四个特性。

事务有四个特性：

- 原子性（Atomicity）：事务是一个原子操作，由一系列动作组成。事务的原子性确保动作要么全部完成，要么完全不起作用。
- 一致性（Consistency）：一旦事务完成（不管成功还是失败），系统必须确保它所建模的业务处于一致的状态，而不会是部分完成部分失败。在现实中的数据不应该被破坏。
- 隔离性（Isolation）：可能有许多事务会同时处理相同的数据，因此每个事务都应该与其他事务隔离开来，防止数据损坏。
- 持久性（Durability）：一旦事务完成，无论发生什么系统错误，它的结果都不应该受到影响，这样就能从任何系统崩溃中恢复过来。通常情况下，事务的结果被写到持久化存储器中。

## 2.事务并发执行时会引发的几个问题

事务并发执行的时候出现了破坏四特性的问题。

- 脏读：A事务还未提交，B事务就读到了A事务的结果（破坏了事务的隔离性）
- 不可重复读：A事务在本次事务中，对自己未操作过的数据，进行了多次读取，结果出现了不一致或记录不存在的情况。（破坏了一致性）
- 幻读：A事务在本次事务中，对自己未操作过的事务，进行了多次读取，第一次读取时，记录不存在，第二次或者以后的读取中，记录突然出现了。（破坏了一致性）

## 3.事务的隔离级别

- **读未提交（Read Uncommitted）**：读未提交，顾名思义，就是可以读到未提交的内容。

- **读提交（Read Committed）**：读提交，顾名思义，就是只能读到已经提交了的内容。

- **可重复读(Repeated Read)**：可以重复读取，但有幻读。读写观点：读取的数据行不可写，但是可以往表中新增数据。在MySQL中，其他事务新增的数据，看不到，不会产生幻读。采用多版本并发控制（MVCC）机制解决幻读问题。

- **串行化（Serializable）**：可读，不可写。像java中的锁，写数据必须等待另一个事务结束。

  

  | 事务隔离级别                     | 脏读 | 不可重复读 | 幻读 |
  | -------------------------------- | ---- | ---------- | ---- |
  | **读未提交（Read Uncommitted）** | 是   | 是         | 是   |
  | **读提交（Read Committed）**     | 否   | 是         | 是   |
  | **可重复读(Repeated Read)**：    | 否   | 否         | 是   |
  | **串行化（Serializable）**       | 否   | 否         | 否   |

  

## 4.spring中的事务管理

​	Spring中实现的事务，底层还是数据库的事务。例如MySQL，只是 Spring在代码层面上实现了事务的操作。（Spring 本身并不实现事务，Spring事务的本质 还是底层数据库对事务的支持，没有数据库事务的支持，Spring事务就不会生效）

​	Spring中有编程式事务与声明式事务两种。目前主流的事务都是采用声明式事务来实现。主要是利用了AOP这个概念进行实现的。

​	声明式事务管理建立在AOP之上，其本质是对方法前后进行拦截，然后在目标方法开始之前创建或者加入一个事务，执行完目标方法之后根据执行的情况提交或者回滚。

​	编程式事务每次实现都要单独实现，但业务量大功能复杂时，使用编程式事务无疑是痛苦的，而声明式事务不同，声明式事务属于无侵入式，不会影响业务逻辑的实现，只需要在配置文件中做相关的事务规则声明或者通过注解的方式，便可以将事务规则应用到业务逻辑中。

​	显然声明式事务管理要优于编程式事务管理，这正是Spring倡导的非侵入式的编程方式。唯一不足的地方就是声明式事务管理的粒度是方法级别，而编程式事务管理是可以到代码块的，但是可以通过提取方法的方式完成声明式事务管理的配置。

### 基于注解`@Transactional`来实现事务

| 属性                   | 类型                               | 描述                                   |
| ---------------------- | ---------------------------------- | -------------------------------------- |
| value                  | String                             | 可选的限定描述符，指定使用的事务管理器 |
| propagation            | enum: Propagation                  | 可选的事务传播行为设置                 |
| isolation              | enum: Isolation                    | 可选的事务隔离级别设置                 |
| readOnly               | boolean                            | 读写或只读事务，默认读写               |
| timeout                | int (in seconds granularity)       | 事务超时时间设置                       |
| rollbackFor            | Class对象数组，必须继承自Throwable | 导致事务回滚的异常类数组               |
| rollbackForClassName   | 类名数组，必须继承自Throwable      | 导致事务回滚的异常类名字数组           |
| noRollbackFor          | Class对象数组，必须继承自Throwable | 不会导致事务回滚的异常类数组           |
| noRollbackForClassName | 类名数组，必须继承自Throwable      | 不会导致事务回滚的异常类名字数组       |

### `isolation`	这个属性是配置事务的隔离级别。对应的值有：

`Isolation.DEFAULT`

​	TransactionDefinition.ISOLATION_DEFAULT这是默认值，表示使用底层数据库的默认隔离级别。对大部分数据库而言，通常这值就是TransactionDefinition.ISOLATION_READ_COMMITTED。

`Isolation.READ_UNCOMMITTED`

TransactionDefinition.ISOLATION_READ_UNCOMMITTED：该隔离级别表示一个事务可以读取另一个事务修改但还没有提交的数据。该级别不能防止脏读，不可重复读和幻读，因此很少使用该隔离级别。比如PostgreSQL实际上并没有此级别。

`Isolation.READ_COMMITTED`

TransactionDefinition.ISOLATION_READ_COMMITTED：该隔离级别表示一个事务只能读取另一个事务已经提交的数据。该级别可以防止脏读，这也是大多数情况下的推荐值。

`Isolation.REPEATABLE_READ`

TransactionDefinition.ISOLATION_REPEATABLE_READ：该隔离级别表示一个事务在整个过程中可以多次重复执行某个查询，并且每次返回的记录都相同。该级别可以防止脏读和不可重复读。

`Isolation.SERIALIZABLE`

TransactionDefinition.ISOLATION_SERIALIZABLE：所有的事务依次逐个执行，这样事务之间就完全不可能产生干扰，也就是说，该级别可以防止脏读、不可重复读以及幻读。但是这将严重影响程序的性能。通常情况下也不会用到该级别。



### propagation 这个属性是配置事务的传播级别。对应的值有：

注：所谓事务的传播行为是指，如果在开始当前事务之前，一个事务上下文已经存在，此时有若干选项可以指定一个事务性方法的执行行为。例如事务A中调用了事务B，那么事务B在事务A调用的时候应该将本身的事务如何处理，这就是事务的传播级别应该解决的事。

`Propagation.REQUIRED`

TransactionDefinition.PROPAGATION_REQUIRED：如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。这是默认值。

`Propagation.SUPPORTS`

TransactionDefinition.PROPAGATION_SUPPORTS：如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务的方式继续运行。

`Propagation.MANDATORY`

TransactionDefinition.PROPAGATION_MANDATORY：如果当前存在事务，则加入该事务；如果当前没有事务，则抛出异常。

`Propagation.REQUIRES_NEW`

TransactionDefinition.PROPAGATION_REQUIRES_NEW：创建一个新的事务，如果当前存在事务，则把当前事务挂起。

`Propagation.NOT_SUPPORTED`

TransactionDefinition.PROPAGATION_NOT_SUPPORTED：以非事务方式运行，如果当前存在事务，则把当前事务挂起。

`Propagation.NEVER`

TransactionDefinition.PROPAGATION_NEVER：以非事务方式运行，如果当前存在事务，则抛出异常。

`Propagation.NESTED`

TransactionDefinition.PROPAGATION_NESTED：如果当前存在事务，则创建一个事务作为当前事务的嵌套事务来运行；如果当前没有事务，则该取值等价于TransactionDefinition.PROPAGATION_REQUIRED。

### readOnly属性

只读事务用于客户代码只读但不修改数据的情形

### timeout属性

所谓事务超时，就是指一个事务所允许执行的最长时间，如果超过该时间限制但事务还没有完成，则自动回滚事务。在 TransactionDefinition 中以 int 的值来表示超时时间，其单位是秒。

  默认设置为底层事务系统的超时值，如果底层数据库事务系统没有设置超时值，那么就是none，没有超时限制。

