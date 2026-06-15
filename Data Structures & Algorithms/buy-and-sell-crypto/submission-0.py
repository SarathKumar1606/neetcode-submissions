class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit=0
        minprice=prices[0]
        for i in range(1,len(prices)):
            minprice=min(minprice,prices[i])
            profit=max(profit,prices[i]-minprice)
        return profit
        