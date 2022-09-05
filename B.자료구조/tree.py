class TreeNode:
    def __init__(self, val, left=None, right=None):
        self.value = val
        self.leftChild = left
        self.rightChild = right

node1 = TreeNode(25)
node2 = TreeNode(75)
root = TreeNode(50, node1, node2)


def search(searchValue, node):
    if node is None or node.value == searchValue:
        return node
    elif searchValue < node.value:
        return search(searchValue, node.leftChild)
    else:
        return search(searchValue, node.rightChild)

def insert(value, node):
    if value < node.value:
        if node.leftChild is None:
            node.leftChild = TreeNode(value)
        else:
            insert(value, node.leftChild)
    elif value > node.value:
        if node.rightChild is None:
            node.rightChild = TreeNode(value)
        else:
            insert(value, node.rightChild)




def delete(delValue, node):
    if node is None:
        return None
    
    #값을 찾지 못한 경우, 재귀함수 호출
    elif delValue < node.value:
        node.leftChild = delete(delValue, node.leftChild)
        return node
    elif delValue > node.value:
        node.rightChild = delete(delValue, node.rightChild)
        return node

    #값을 찾은 경우
    elif delValue == node.value:
        #해당 노드에 왼쪽 자식이 없다면, 
        if node.leftChild is None:
            #node.leftChild = delete()에서
            #delete()가 node.rightChild를 return하므로, 
            #node.leftChild = node.rightChild
            #그러므로 leftChild의 자리를 rightChild가 대체하고, leftChild는 '삭제'된다.
            return node.rightChild
        
        #반대로 오른쪽 자식이 없다면, 
        elif node.rightChild is None:
            return node.leftChild