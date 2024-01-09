//{ Driver Code Starts
//Initial Template for javascript

//Initial Template for javascript
'use strict';

let inputString = '';
let currentLine = 0;

class Node{
    constructor(data){
        this.data = data;
        this.next = null;
    }
}

let head = null;

function findNode(head, search_for)
{
    let current = head;
    while (current !== null)
    {
        if (current.data == search_for)
            break;
        current = current.next;
    }
    return current;
}

function printlist(head){
    let current = head; 
    let s='';
    while (current !== null)
    {
        s+=current.data+" ";
        current = current.next;
    }
    console.log(s);
}

class Solution {
    
    mergeResult(node1, node2)
    {
        let resultNode = null;

        if(node1 && !node1.data) {
            node1 = null;
        }

        if(node2 && !node2.data) {
            node2 = null;
        }
        
        while(node1 || node2) {
            let currentNode = null;
            if(!node2 || (node1 && (node1.data < node2.data))) {
                currentNode = node1.data ? new Node(node1.data) : null;
                node1 = node1.next;
            } else {
                currentNode = node2.data ? new Node(node2.data) : null;
                node2 = node2.next;
            }
            
            if(resultNode) {
                currentNode.next = resultNode;
            }
            
            resultNode = currentNode;
        }
        
        return resultNode;
    }
}


function main() {
    let input_ar1 = [];
    head = null;
    head = new Node(input_ar1[0]);
    let tail = head;
    for(let i=1;i<input_ar1.length;i++){
        tail.next = new Node(input_ar1[i]);
        tail = tail.next;
    }
    input_ar1 = [5, 10, 15];
    let head1 = new Node(input_ar1[0]);
    tail = head1;
    for(let i=1;i<input_ar1.length;i++){
        tail.next = new Node(input_ar1[i]);
        tail = tail.next;
    }
    let obj = new Solution();
    let res = obj.mergeResult(head, head1);
    printlist(res);
}

main()

// } Driver Code Ends


//User function Template for javascript

/**
 * @param {Node} node1
 * @param {Node} node2
*/

/*
class Node{
    constructor(data){
        this.data = data;
        this.next = null;
    }
}
*/
