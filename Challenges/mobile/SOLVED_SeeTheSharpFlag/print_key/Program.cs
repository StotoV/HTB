// See https://aka.ms/new-console-template for more information
using System;
using System.Security.Cryptography;

Console.WriteLine("Hello, World!");

byte[] buffer = Convert.FromBase64String("sjAbajc4sWMUn6CHJBSfQ39p2fNg2trMVQ/MmTB5mno=");
byte[] rgbKey = Convert.FromBase64String("6F+WgzEp5QXodJV+iTli4Q==");
byte[] rgbIV = Convert.FromBase64String("DZ6YdaWJlZav26VmEEQ31A==");
using AesManaged aesManaged = new AesManaged();
using ICryptoTransform transform = aesManaged.CreateDecryptor(rgbKey, rgbIV);
using MemoryStream stream = new MemoryStream(buffer);
using CryptoStream stream2 = new CryptoStream(stream, transform, CryptoStreamMode.Read);
using StreamReader streamReader = new StreamReader(stream2);
Console.WriteLine(streamReader.ReadToEnd());