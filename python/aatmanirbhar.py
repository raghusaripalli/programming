import_item_map = dict()
local_item_map = dict()
total_price = 0
n = int(input())

for i in range(0, n):
    name, qty, price = list(map(str, input().strip().split()))
    import_item_map[name] = [int(qty), int(price)]

m = int(input())
for i in range(0, m):
    name, qty, price = list(map(str, input().strip().split()))
    local_item_map[name] = [int(qty), int(price)]

for item in import_item_map:
    import_qty, import_price = import_item_map[item]
    if item in local_item_map:
        local_qty, local_price = local_item_map[item]
        if import_qty - local_qty <= 0:
            total_price += import_qty * local_price
        else:
            total_price += local_qty * local_price
            total_price += (import_qty - local_qty) * import_price

    else:
        total_price += import_qty * import_price

print(total_price)
