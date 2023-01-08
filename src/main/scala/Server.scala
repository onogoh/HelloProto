//package com.YAEngineers.Protobuf
//
//import cats.effect.{ExitCode, IO, IOApp}
//
//import scala.concurrent.duration.DurationInt
//
//object Server extends IOApp {
//
//
//  def run(args:List[String]): IO[ExitCode] = {
//
//    def differentThreads() = for {
//      fib <- longRunningTask(2).start
//      _ <- debug(IO("Scala")).start
//      _ <- debugs(IO("Scala33")).start
//    } yield ()
//    differentThreads().as(ExitCode.Success)
//
////    Thread.sleep(20000)
////    println("")
//
//
//
//  }
//
//  def longRunningTask(n:Int): IO[Unit] = {
//    println(s"We are printing this value ${Thread.currentThread().getName} ")
//    IO.pure {
//      var s = 0
//      while (true) {
//        Thread.sleep(10)
//        println(s"We are printing this value $n ${Thread.currentThread().getName} $s times")
//        s += 1
//        if (s >= 500) {
//          return IO.pure(new RuntimeException("Failed"))
//        }
//      }
//    }
//  }
//
//  implicit def debug[String](io:IO[String]): IO[String] = io.map { value =>
//    println("ready 1")
//    IO.sleep(5.seconds)
//    println(s"[${Thread.currentThread().getName}] $value")
//    value
//  }
//
//  implicit def debugs[String](io: IO[String]): IO[String] = io.map { value =>
//    println("ready 2")
//    IO.sleep(10000.millis)
//    println(s"[${Thread.currentThread().getName}] $value")
//    value
//  }
//
//}
