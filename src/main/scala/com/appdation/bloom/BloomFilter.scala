package com.appdation.bloom

import com.plasmaconduit.waterhouse._

case class BloomFilter(bitTable: Array[Boolean], hashFunctions: List[HashAlgorithm]) {

  def getNumberOfBits: Int = bitTable.length

  def addKey(key: String) = {
    hashFunctions.foreach(h => {
      val digest = Hash.digest(h, key)
      bitTable((BigInt(digest.toString(), 16) % getNumberOfBits).intValue) = true
    })
  }

  def checkForKey(key: String): Boolean = {
    hashFunctions.map(h => {
      val digest = Hash.digest(h, key)
      bitTable((BigInt(digest.toString(), 16) % getNumberOfBits).intValue)
    }).foldLeft(true)((a, b) => a && b)
  }

}

object BloomFilter {

  def apply(numBits: Int, hashFunctions: List[HashAlgorithm]): BloomFilter = {
    return new BloomFilter(new Array[Boolean](numBits), hashFunctions)
  }

}
